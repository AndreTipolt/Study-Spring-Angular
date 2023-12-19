import { Component, OnInit } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Course } from '../models/course';
import { CoursesService } from '../services/courses.service';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses$: Observable<Course[]>;

  displayedColumns = ['name', 'category']
  constructor(private coursesServices: CoursesService, private dialog: MatDialog) {
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

}
