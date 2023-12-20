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
        tap((courses) => console.log(courses))
      );
  }

  save(record: Course): Observable<Course>{
    
    return this.httpClient.post<Course>(this.API, record).pipe(first());
  }

  findById(id: string){
    const newUrl = `${this.API}/${id}`;

    return this.httpClient.get<Course>(newUrl)
  }
}
