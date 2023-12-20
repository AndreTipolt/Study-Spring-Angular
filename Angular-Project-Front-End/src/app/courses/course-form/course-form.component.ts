import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CoursesService } from '../services/courses.service';
import { MatSnackBar } from '@angular/material/snack-bar'

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form: FormGroup
  constructor(private formBuilder: FormBuilder, private courseService: CoursesService, private _snackBar: MatSnackBar) {
    this.form = this.formBuilder.group({

      name: [null],
      category: [null]
    });
  }

  ngOnInit(): void {
  }

  onSubmit(){
    
    this.courseService.save(this.form.value).subscribe((data) => { console.log(data) }, (error) => { this.onError() });
  }
  
  onCancel(){

  }

  private onError(){
    this._snackBar.open('Erro ao adicionar curso', '', { duration: 2000 })
  }
}
