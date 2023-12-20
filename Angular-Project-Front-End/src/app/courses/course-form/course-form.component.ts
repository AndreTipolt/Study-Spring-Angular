import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NonNullableFormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CoursesService } from '../services/courses.service';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../models/course';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form: FormGroup = this.formBuilder.group({

    _id: new FormControl<string | null>(''),
    name: new FormControl<string | null>('', { nonNullable: true }),
    category: new FormControl<string | null>('', { nonNullable: true }),
  });

  constructor(private formBuilder: NonNullableFormBuilder,
    private courseService: CoursesService,
    private _snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {

    const course: Course = this.route.snapshot.data['course']; // Pegando o course do resolver que vai vai vir vazio ou nao
    
    this.form.setValue({
      _id: course._id,
      name: course.name,
      category: course.category
    })
  }

  onSubmit() {

    this.courseService.save(this.form.value).subscribe((data) => { this.onSucess() }, (error) => { this.onError() });
  }

  onCancel() {
    this.location.back();
  }

  private onSucess() {
    this._snackBar.open('Curso adicionado com sucesso', '', { duration: 2000 })
    this.onCancel()
  }

  private onError() {
    this._snackBar.open('Erro ao adicionar curso', '', { duration: 2000 })
  }
}
