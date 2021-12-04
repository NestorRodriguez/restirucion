import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PostService } from '../post/post.service';

@Component({
  selector: 'app-publish-shared',
  templateUrl: './publish-shared.component.html',
  styleUrls: ['./publish-shared.component.css']
})
export class PublishSharedComponent implements OnInit {

  post : Array<Object>;
  user = {"id":0,"password":"","nombre":"","mail":"","rol":{"id":0,"descripcion":""}};

  constructor(private postService: PostService, public router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.user == undefined)
      this.router.navigateByUrl('/login');
    else{
      this.user=JSON.parse( sessionStorage.user);
      this.postService.getPostByUserId(this.user.id).subscribe(
        (post) => this.post = post
      );
    }
  }

}
