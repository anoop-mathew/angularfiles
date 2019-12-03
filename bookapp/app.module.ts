import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';

import { HttpClientModule } from '@angular/common/http';
import { BookService } from './book.service';
import { LoginComponent } from './login/login.component';
import { BookGuard } from './guards/book.guard';
import { MemberComponent } from './member/member.component';
import { AdminComponent } from './admin/admin.component';
import { MemberviewComponent } from './memberview/memberview.component';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    LoginComponent,
    MemberComponent,
    AdminComponent,
    MemberviewComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BookService,BookGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
