import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { BookComponent } from './book/book.component';
import { BookGuard } from './guards/book.guard';
import { MemberComponent } from './member/member.component';
import { AdminComponent } from './admin/admin.component';
import { MemberviewComponent } from './memberview/memberview.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
{ path: 'login', component: LoginComponent},
{ path: 'logout', component: LoginComponent},
{ path: 'admin', component: AdminComponent, canActivate : [BookGuard]},
{ path: 'book', component: BookComponent, canActivate : [BookGuard]},
{ path: 'member', component: MemberComponent, canActivate : [BookGuard]},
{ path: 'memberview', component: MemberviewComponent, canActivate : [BookGuard]}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
