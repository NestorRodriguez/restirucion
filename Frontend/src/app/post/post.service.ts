import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  serverUrlUsers='http://localhost:8082/api/post';

  constructor(public http: HttpClient) { }

  getPost():
    Observable<any[]> {
      return this.http.get<any[]>(this.serverUrlUsers).pipe(
        tap(data => console.log(JSON.stringify(data))),
        catchError(this.handleError)
      );
    }

    getPostByUserId(id):
    Observable<any[]> {
      return this.http.get<any[]>(this.serverUrlUsers+"/"+id+"/"+true).pipe(
        tap(data => console.log(JSON.stringify(data))),
        catchError(this.handleError)
      );
    }

    private handleError(err: HttpErrorResponse) {
      let errorMessage = '';
      if (err.error instanceof ErrorEvent) {
        errorMessage = `An error ocurred ${err.error.message}`;
      } else {
        errorMessage = `Server returned code: ${err.status}, error message is:   ${err.message}`;
        // tslint:disable-next-line:align
      } console.log(errorMessage);
      return throwError(errorMessage);
    }
}
