import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MatDialogRef, MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ConfirmDialogComponent } from "../../shared/confirm-dialog/confirm-dialog.component";

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  ModelRef: MatDialogRef<ConfirmDialogComponent>;
  
  constructor(
    public dialog : MatDialog,
  ) { }

  public dialogBox(data:String): Observable<boolean>{
    
    this.ModelRef = this.dialog.open(ConfirmDialogComponent,
      { width: '50%' }
    );
    this.ModelRef.componentInstance.data = data;
    return this.ModelRef.afterClosed();
  }
}
