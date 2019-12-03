import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Admin } from '../admin';
import { AddDoctorService } from './add-doctor.service';
import { LoginService } from '../login/login.service';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.scss']
})
export class AddDoctorComponent implements OnInit {

  doctor=new Admin();
  
  confPass:string;
  errMssg:string;

  constructor(private route:ActivatedRoute,private logout: LogoutService, private router:Router,private addDotorService:AddDoctorService) { }

  ngOnInit() {
    this.route.params.subscribe(params=>this.getDoctorById(params['sId']));
  }

  addDoctors():void{
   
    this.addDotorService.addDoctor(this.doctor)
    .subscribe((response)=>{
      this.ViewDoctor();
    },(error)=>{
      console.log(error);
    });
  }
/*
  addDoctors():void{
    console.log(this.doctor);
  }*/

  getDoctorById(sId: number){
    this.addDotorService.getDocById(sId)
    .subscribe((docData)=>{
      this.doctor=docData;
      console.log(this.doctor);
    },(error)=>{
      console.log(error);
    });
  }
  

  ckeckPass():void{
    if(this.doctor.password===this.confPass){
      this.addDoctors();
    }
    else{
      this.errMssg="Confirm Password";
    }
  }

  private reset() {
    this.doctor.sName=undefined;
    this.doctor.sDOB=undefined;
    this.doctor.sGender=undefined;
    this.doctor.sAddr=undefined;
    this.doctor.sPhNo=undefined;
    this.doctor.sEmail=undefined;
    this.doctor.dQualification=undefined;
    this.doctor.sExp=undefined;
    this.doctor.dSpec=undefined;
    this.doctor.consultFee=undefined;
    this.doctor.username=undefined;
    this.doctor.password=undefined;
    this.confPass=undefined;
    this.doctor.sunday=undefined;
    this.doctor.monday=undefined;
    this.doctor.tuesday=undefined;
    this.doctor.wednesday=undefined;
    this.doctor.thursday=undefined;
    this.doctor.friday=undefined;
    this.doctor.saturday=undefined;
    this.errMssg="";

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
