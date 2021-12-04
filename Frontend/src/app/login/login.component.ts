import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogService } from '../services/dialog/dialog.service';
import { LoadingService } from '../services/loading/loading.service';
import { LoginService } from "./login.service";

import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  user;
  loading$ = this.loader.loading$;
  data;

  constructor(
    private loginService: LoginService, 
    public loader: LoadingService,
    public dialogbox: DialogService,
    public dialog: MatDialog,
    public router:Router
    ) {}

  login() {
    const usuario = {
      mail: this.email, 
      password: this.password
    };
    this.user=this.loginService.login(usuario).subscribe(
      (user)=>{
        this.user = user;
        if(this.user == null){
          this.data= {tittle : "Error", message : "El usuario no existe o las credenciales son invalidas, por favor, intente de nuevo"};
          this.dialogbox.dialogBox(this.data.message);
          this.email="";
          this.password="";
        }
        else if(this.user.rol.descripcion == "Inversionista"){
          this.router.navigateByUrl('/post');   
          this.user.password="";
          sessionStorage.setItem("user",JSON.stringify(this.user));
        }
        else if(this.user.rol.descripcion == "Emprendedor"){ 
          this.router.navigateByUrl('/publish');      
          this.user.password="";
          sessionStorage.setItem("user",JSON.stringify(this.user));
        }
        
      },
      error => {
        this.data= {tittle : error, message : "No se pudo establecer la conexión, por favor, intentelo más tarde"};
        this.dialogbox.dialogBox(this.data.message);
      }
    );
  }

  ngOnInit(): void {
  }

}
