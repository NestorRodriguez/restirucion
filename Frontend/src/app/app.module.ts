import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header/header.component';
import { FooterComponent } from './footer/footer/footer.component';
import { PostComponent } from './post/post.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { FormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { MatDialogModule } from "@angular/material/dialog";
import { NetworkInterceptor } from './network.interceptor';
import { ConfirmDialogComponent } from './shared/confirm-dialog/confirm-dialog.component';
import { RegisterComponent } from './register/register.component';
import { PublishComponent } from './publish/publish.component';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { ModalFormComponent } from './shared/modal-form/modal-form.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { PublishSharedComponent } from './publish-shared/publish-shared.component';
import { HomeComponent } from './home/home.component';
import { MatCardModule} from '@angular/material/card';  

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    PostComponent,
    LoginComponent,
    ConfirmDialogComponent,
    RegisterComponent,
    PublishComponent,
    ModalFormComponent,
    PublishSharedComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatButtonModule,
    MatIconModule,
    NgbModule,
    MatCheckboxModule,
    MatCardModule
  ],
  entryComponents:[ConfirmDialogComponent],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: NetworkInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
