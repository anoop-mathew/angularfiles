import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Admin } from '../admin';
import { AddStaffService } from './add-staff.service';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-add-staff',
  templateUrl: './add-staff.component.html',
  styleUrls: ['./add-staff.component.scss']
})
export class AddStaffComponent implements OnInit {

  constructor(private route:ActivatedRoute,private logout: LogoutService,private router:Router,private addStaffService:AddStaffService) { }
  roles:Admin[];
  staff=new Admin();
  confPass:string;
  errMssg:string;
  ngOnInit() {
    this.route.params.subscribe(params=>this.getsatffById(params['sId']));
    this.getRoles();
  }
 
  getRoles():void{
    this.addStaffService.getAllRoles()
    .subscribe((roleData)=>{
      this.roles=roleData
    },(error)=>{
      console.log(error);
    });
  }
 addStaff():void{
    this.addStaffService.addStaffServ(this.staff)
    .subscribe((response)=>{
      this.ViewStaff();
    },(error)=>{
      console.log(error);
    });
  }

  checkPass():void{
    if(this.staff.password===this.confPass){
      this.addStaff();
    }
    else{
      this.errMssg="Confirm Password"
    }
  }

  getsatffById(sId:number){
    this.addStaffService.getstafById(sId)
    .subscribe((docData)=>{
      this.staff=docData;
    },(error)=>{
      console.log(error);
    });
  }

 

/*
  addStaff():void{
    
      console.log(this.staff);
  }*/

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
