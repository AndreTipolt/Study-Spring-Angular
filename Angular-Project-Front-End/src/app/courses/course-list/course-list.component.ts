import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Course } from '../models/course';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.scss']
})
export class CourseListComponent implements OnInit {

  readonly displayedColumns = ['_id','name', 'category', 'actions']

  @Input() courses!: Course[];
  @Output() add = new EventEmitter(false);

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }


  onAdd(){

    // this.router.navigate(['courses/new']); // mesma coisa que isso aqui

    // this.router.navigate(['new'], {relativeTo: this.route })

    this.add.emit(true);
  }
}
