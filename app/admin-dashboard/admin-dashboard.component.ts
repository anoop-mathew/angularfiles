import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminDashboardService } from './admin-dashboard.service';
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss']
})
export class AdminDashboardComponent implements OnInit {
 

  constructor(private router:Router, private AdminSer:AdminDashboardService) { }

  ngOnInit() {
  }

  
  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
  }
  
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
  }

  Admin()
  {
    this.router.navigate(['/Admin']);
  }
  
  ViewStaff()
  {
    this.router.navigate(['/ViewStaff']);   
  }
   
  AddStaff()
  {
    this.router.navigate(['/AddStaff']);   
  }

  
  ViewDoctor()
  {
    this.router.navigate(['/ViewDoctor']);   
  }
   
    
  AddDoctor()
  {
    this.router.navigate(['/AddDoctor']);   
  }

  ViewMedicine()
  {
    this.router.navigate(['/ViewMedicine']);   
  }

  Logout() {  
    console.log('Logout');  
    this.AdminSer.Logout();
  } 

}
