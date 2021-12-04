import { Component, OnInit } from '@angular/core';
import { PublishService } from './publish.service';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DialogService } from '../services/dialog/dialog.service';
import { LoadingService } from '../services/loading/loading.service';


@Component({
  selector: 'app-publish',
  templateUrl: './publish.component.html',
  styleUrls: ['./publish.component.css']
})
export class PublishComponent implements OnInit {

  documento: String;
  username: String;
  closeResult:String;
  users = new Array<Object>();
  usersTemp;
  user;
  data;
  loading$ = this.loader.loading$;
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
    public loader: LoadingService,
    public dialogbox: DialogService,
    ) { }

  ngOnInit(): void {

  }

  find(){
    if(this.documento == "") this.documento=null;
    if(this.username == "") this.username=null;
    console.log(this.documento)
    console.log(this.username)
    const usuario = {
      documento: this.documento,
      username: this.username,
      
    };
    this.user = this.publishService.findByUserOrDocument(usuario).subscribe(
      data => {
        console.log(data)
        this.user = data;
        if( data.id == 0 ){
          this.data= {tittle : "Mensaje", message : "No hubo resultados en su busqueda"};
          this.dialogbox.dialogBox(this.data.message);
          if(this.users.length > 0){
            this.users.pop()
          }
          //this.users = this.usersTemp;
        }
        else{
          this.users.push(data);
        }
        
      }
    )
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
 

  delete(id){
    console.log(id)
    this.publishService.delete(id).subscribe(
      data => {
        console.log("successful");
        window.location.reload();
      }
    )
  }

}
