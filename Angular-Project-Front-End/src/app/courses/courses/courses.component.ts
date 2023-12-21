import { Component, OnInit } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Course } from '../models/course';
import { CoursesService } from '../services/courses.service';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConfirmationDialogComponent } from 'src/app/shared/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses$!: Observable<Course[]>;

  displayedColumns = ['_id', 'name', 'category', 'actions']
  constructor(private coursesServices: CoursesService,
    private dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private matSnackBar: MatSnackBar,
  ) {

    this.refresh();
  }

  refresh() {

    this.courses$ = this.coursesServices.list().pipe(
      catchError((error) => {
        this.onError("Erro ao carregar cursos");
        return of([])
      })
    )
  }

  ngOnInit(): void {

  }

  onError(errorMessage: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMessage
    })
  }

  onAdd() {

    // this.router.navigate(['courses/new']); // mesma coisa que isso aqui

    this.router.navigate(['new'], { relativeTo: this.route })
  }

  onEdit(course: Course) {

    this.router.navigate(['edit', course._id], { relativeTo: this.route })
  }

  onDelete(id: string) {

    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '250px',
      data: "Deseja remover o curso?",
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {

      if (result) {
        this.coursesServices.delete(id).subscribe(() => {
          this.refresh()

          this.matSnackBar.open("Curso Removido com Sucesso")
        }, (error) => {
          this.onError("Erro ao remover curso")
        })
      }
    });
  }
}
