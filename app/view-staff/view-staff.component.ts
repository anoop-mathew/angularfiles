import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { ViewStaffService } from './view-staff.service';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-view-staff',
  templateUrl: './view-staff.component.html',
  styleUrls: ['./view-staff.component.scss']
})
export class ViewStaffComponent implements OnInit {

  staffs:Admin[];
  staff=new Admin();
  constructor(private router:Router,private logout: LogoutService,private viewStaffService:ViewStaffService) { }

  ngOnInit() {
    this.getStaffs();
  }
  getStaffs():void{
    this.viewStaffService.getAllStaffs()
    .subscribe((staffData)=>{
      this.staffs=staffData;
    },(error)=>{
      console.log(error);
    });
  }

  disableStaff(staff:Admin):void{
    this.viewStaffService.disableAStaff(staff)
    .subscribe((response)=>{
      this.getStaffs();
    },(error)=>{
      console.log(error);
    });
  }
/*
  disableStaff(staff:Admin):void{
    
      console.log(staff);
    
  }*/

  editStaff(sId:number){
    this.router.navigate(['/editStaff/'+sId]);
  }

  searchStaff(searchString:string){
    console.log(searchString);
    this.viewStaffService.searchStaff(searchString).subscribe((response)=>{
      this.staffs= response
      console.log(this.staffs);
    },(error)=>{
      console.log(error);
  

    });
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

  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 
  


}
