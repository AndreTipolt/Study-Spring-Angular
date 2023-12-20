import { Component, OnInit } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Course } from '../models/course';
import { CoursesService } from '../services/courses.service';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses$: Observable<Course[]>;

  displayedColumns = ['_id','name', 'category', 'actions']
  constructor(private coursesServices: CoursesService, private dialog: MatDialog, private router: Router, private route: ActivatedRoute) {
    this.courses$ = this.coursesServices.list().pipe(
      catchError((error) => {
        this.onError("Erro ao carregar cursos");
        return of([])
      })
    )
  }

  ngOnInit(): void {

  }

  onError(errorMessage: string){
    this.dialog.open(ErrorDialogComponent, {
      data: errorMessage
    })
  }

  onAdd(){

    // this.router.navigate(['courses/new']); // mesma coisa que isso aqui

    this.router.navigate(['new'], {relativeTo: this.route })
  }

}
