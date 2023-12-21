import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, first, tap } from 'rxjs';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = "api/course"

  constructor(private httpClient: HttpClient) { }

  list(): Observable<Course[]> {


    return this.httpClient.get<Course[]>(this.API).pipe(
        first(),
        tap()
      );
  }

  save(record: Course): Observable<Course>{
    
    if(record._id){
      
      return this.update(record);
    }
    
    return this.create(record);
  }

  findById(id: string){
    const newUrl = `${this.API}/${id}`;

    return this.httpClient.get<Course>(newUrl)
  }

  private create(course: Course){
    return this.httpClient.post<Course>(this.API, course).pipe(first());
  }

  private update(course: Course){
    const newUrl = `${this.API}/${course._id}`;

    return this.httpClient.put<Course>(newUrl, course);
  }

  delete(id: string){
    const newUrl = `${this.API}/${id}`;

    return this.httpClient.delete(newUrl);
  }
}
