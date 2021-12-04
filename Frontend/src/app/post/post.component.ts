import { Component, OnInit } from '@angular/core';
import { PostService } from './post.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  post : Array<Object>;
  user = {"id":0,"password":"","nombre":"","mail":"","rol":{"id":0,"descripcion":""}};

  constructor(private postService: PostService, public router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.user == undefined)
      this.router.navigateByUrl('/login');
    else
      this.postService.getPost().subscribe(
        (post) => this.post = post
      );
  }

}
