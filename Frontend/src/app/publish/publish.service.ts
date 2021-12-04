import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PublishService {

  serverUrlUsers='http://localhost:8082/api/usuario';

  constructor(public http: HttpClient) { }

  getPost():
    Observable<any[]> {
      return this.http.get<any[]>(this.serverUrlUsers).pipe(
        tap(data => console.log(JSON.stringify(data))),
        catchError(this.handleError)
      );
    }

  getUsers():
    Observable<any[]> {
      return this.http.get<any[]>(this.serverUrlUsers).pipe(
        tap(data => console.log(JSON.stringify(data))),
        catchError(this.handleError)
      );
    }

  findByUserOrDocument(usuario):
    Observable<any> {
      return this.http.post<any[]>(this.serverUrlUsers+"/find", usuario).pipe(
        tap(data => console.log("Busqueda")),
        catchError(this.handleError)
      );
    }

  getPostByIdUsuario(id):
    Observable<any[]> {
      return this.http.get<any[]>(this.serverUrlUsers+"/"+id).pipe(
        tap(data => console.log(JSON.stringify(data))),
        catchError(this.handleError)
      );
    }

    update(user):
    Observable<any> {
      return this.http.put<any[]>(this.serverUrlUsers, user).pipe(
        tap(data => console.log(JSON.stringify(data))),
        catchError(this.handleError)
      );
    }

    delete(id):
    Observable<any> {
      return this.http.delete<any[]>(this.serverUrlUsers+"/"+id).pipe(
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
