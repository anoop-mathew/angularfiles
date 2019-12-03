import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AddVendorComponent } from './add-vendor/add-vendor.component';
import { AuthGuard } from './guards/auth.guard';


const routes: Routes = [
  {path: '', redirectTo: 'Login', pathMatch: 'full'},
  {path:'Login', component:LoginComponent},
  {path:'Home', component:UserDashboardComponent,canActivate : [AuthGuard]},
  {path:'AddVendor', component:AddVendorComponent,canActivate : [AuthGuard]},
  {path:'editVendor/:vendorId', component:AddVendorComponent,canActivate : [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
