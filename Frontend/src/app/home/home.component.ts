import { Component, OnInit } from '@angular/core';
import { LoadingService } from '../services/loading/loading.service';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loading$ = this.loader.loading$;

  constructor(
    public loader: LoadingService,
  ) { }

  ngOnInit(): void {
  }

}
