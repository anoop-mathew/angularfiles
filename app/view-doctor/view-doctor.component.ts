import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ViewDoctorService } from './view-doctor.service';
import { Admin } from '../admin';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-view-doctor',
  templateUrl: './view-doctor.component.html',
  styleUrls: ['./view-doctor.component.scss']
})
export class ViewDoctorComponent implements OnInit {
doctors: Admin[];
doctor= new Admin();

  constructor(private router:Router, private logout: LogoutService,private _viewdoctor: ViewDoctorService) { }

  ngOnInit() {
    this.getAllDoctors();
  }
  getAllDoctors(): void{
    this._viewdoctor.getAllDoctors()
    .subscribe((doctorData)=>{
      this.doctors=doctorData,
      console.log(doctorData);
    }, (error) =>{
      console.log(error);
    });
  }

  disableDoc(doc:Admin){
    this._viewdoctor.disableDoctor(doc)
    .subscribe((response)=>{
      this.getAllDoctors();
    }, (error) =>{
      console.log(error);
    });
  }
  
  editDoctor(sId:number){
    this.router.navigate(['editDoc/'+sId]);
  }

  searchDoctor(search: string): void{
    if (search!=null){
    console.log(search);
    this._viewdoctor.searchDoctor(search)
    .subscribe((response)=>{
      this.doctors=response
      console.log(this.doctors);
    }, (error) =>{
      console.log(error);
      //this.getDoctors();
    });
  }else{
    this.getAllDoctors();
  }
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
