import { Component, OnInit } from '@angular/core';
import { PublishService } from './publish.service';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { throwIfEmpty } from 'rxjs/operators';


@Component({
  selector: 'app-publish',
  templateUrl: './publish.component.html',
  styleUrls: ['./publish.component.css']
})
export class PublishComponent implements OnInit {

  closeResult:String;
  users;
  compartir;
  publishing=
  { "id": 0, "titulo": "", "descripcion": "", "compartir": false,
    "usuario": { "id": 0, "password": "", "nombre": "", "mail": "",
        "rol": { "id": 0, "descripcion": ""}}
  }

  constructor(
    private publishService: PublishService, 
    public router:Router,
    private modalService: NgbModal,
    ) { }

  ngOnInit(): void {
  /*  if(sessionStorage.user == undefined)
      this.router.navigateByUrl('/login');
    else*/
      //this.publishing.usuario = JSON.parse(sessionStorage.user);
      this.publishService.getUsers().subscribe(
        (post) =>{
          this.users = post;
          
        }
      );
  }

  update(content, user){
    this.publishing.id = user.id;
    this.publishing.titulo = user.titulo;
    this.publishing.descripcion = user.descripcion;
    this.publishing.compartir == true ? this.compartir=1 : this.compartir=0;  
    this.publishing.usuario = user.usuario;
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  addPost(content) {
    /*this.publishing.titulo = user.titulo;
    this.publishing.descripcion = user.descripcion;*/
    this.publishing.usuario = JSON.parse( sessionStorage.user);
    //console.log(this.publishing);
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
  register(){
    this.compartir == 1 ? this.publishing.compartir=true: this.publishing.compartir=false;
    this.publishService.update(this.publishing).subscribe(
      data => {
        console.log("successful");
        window.location.reload();
        this.publishing = 
        { "id": 0, "titulo": "", "descripcion": "", "compartir": false,
          "usuario": { "id": 0, "password": "", "nombre": "", "mail": "",
          "rol": { "id": 0, "descripcion": ""}}
        }
      },
      error=>{

      }
    )
  }
  

  delete(id){
    this.publishService.delete(id).subscribe(
      data => {
        console.log("successful");
        window.location.reload();
      }
    )
  }

}
