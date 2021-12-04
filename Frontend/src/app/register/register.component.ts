import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogService } from '../services/dialog/dialog.service';
import { LoadingService } from '../services/loading/loading.service';
import { Router } from '@angular/router';
import { RegisterService } from './register.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name: String;
  secondName: String;
  lastName: String;
  secondLastName: String;
  email: String;
  numero: String;
  password: String;
  user;
  tipoDocumento;
  tiposDocumentos : any;
  genero;
  generos : any;
  username: String;
  rol;
  loading$ = this.loader.loading$;
  data;
  roles: any ;
  

  constructor(
    public registerService : RegisterService,
    public loader: LoadingService,
    public dialogbox: DialogService,
    public dialog: MatDialog,
    public router:Router
  ) { }

  ngOnInit(): void {
    this.registerService.getParameter(1).subscribe(
      (genero)=>{
        this.generos = genero;
      });
      this.registerService.getParameter(2).subscribe(
        (tipos)=>{
          this.tiposDocumentos = tipos;
        });
        this.genero = -1;
        this.tipoDocumento = -1;
  }

  register(){
    if(this.genero == -1 || this.tipoDocumento == -1)
      return;
    const usuario = {
      nombre: this.name,
      segundoNombre: this.secondName,
      apellido: this.lastName,
      segundoApellido: this.secondLastName,
      numero: this.numero,
      tipoDocumento: {
        "id":this.tipoDocumento,
        "descripcion":""
      },
      genero:{
        "id":this.genero,
        "descripcion":""
      },
      ususrio: this.username,
      mail: this.email, 
      rol: {
        "id":this.rol,
        "descripcion":"",
        "estado":"",
        "idTipoParametro":""
      }
    };
    this.tiposDocumentos.forEach(element => {
      if(element.id == this.tipoDocumento){
        usuario.tipoDocumento = element;
      }
    });
    console.log(usuario)
    // this.user = this.registerService.register(usuario).subscribe(
    //   data => {
    //     this.user = data;
    //     if( data.id ==0 ){
    //       this.data= {tittle : "Mensaje", message : "Usted ya se encuentra registrado en el sistema"};
    //       this.dialogbox.dialogBox(this.data.message);
    //     }
    //     else{
    //       this.data= {tittle : "Mensaje", message : "Usuario registrado con éxito, por favor, inicie sesión"};
    //       this.dialogbox.dialogBox(this.data.message);
    //       this.router.navigateByUrl('/login'); 
    //     }
    //     this.email="";
    //     this.password="";
    //     this.name="";
    //     this.rol=0;
    //   }
    // )
  } 
}
