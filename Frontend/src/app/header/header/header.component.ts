import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  sesion;
  user;
  rol;

  constructor() { }

  ngOnInit(): void {
    if(sessionStorage.user == undefined)
      this.sesion = false;
    else{ 
      this.sesion=true;
      this.user = JSON.parse(sessionStorage.user);
      if(this.user.rol.descripcion == "Emprendedor")
        this.rol = true;
      else
        this.rol=false;
    }
  }

  cerrarSesion(){
    console.log("Cerrando sesión");
    sessionStorage.clear();
    this.sesion = false;
  }

}
