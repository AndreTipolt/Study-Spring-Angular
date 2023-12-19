import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from '../models/course';
import { CoursesService } from '../services/courses.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses!: Observable<Course[]>;

  displayedColumns = ['name', 'category']
  constructor(private coursesServices: CoursesService) {
    this.courses = this.coursesServices.list()
  }

  ngOnInit(): void {

  }

}
