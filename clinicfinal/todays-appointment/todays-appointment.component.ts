import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodaysAppointmentService } from './todays-appointment.service';
import { FrontOffice } from '../frontOffice';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-todays-appointment',
  templateUrl: './todays-appointment.component.html',
  styleUrls: ['./todays-appointment.component.scss']
})
export class TodaysAppointmentComponent implements OnInit {
todaysappoinment: FrontOffice[];
todayappoinment= new FrontOffice();
  constructor(private router:Router,private logout: LogoutService,private _todaysappointment:TodaysAppointmentService) { }

  ngOnInit() {
    this.getTodaysAppoinment();
  }

  ViewPatientByRegId(regId:number):void{
    console.log(regId);
   this.router.navigate(['/ViewPatient/'+regId]);
  }
  getTodaysAppoinment(): void{
    this._todaysappointment.getappointments()
    .subscribe((appoinmentData)=>{
      this.todaysappoinment=appoinmentData,
      console.log(appoinmentData);
    }, (error) =>{
      console.log(error);
    });
  }

  SearchPatient(search: string): void{
    console.log(search);
    this._todaysappointment.SearchPatient(search)
    .subscribe((patientData)=>{
      this.todaysappoinment=patientData,
      console.log(search + "  Length " + search.length);
      if(search===undefined){
        console.log("Here");
        this.getTodaysAppoinment;
      }

      /*if(search==null)
      {
        this.getTodaysAppoinment();
      }*/

    }, (error) =>{
      console.log(error);
      this.getTodaysAppoinment();
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

  ViewPatient()
  {
    this.router.navigate(['/ViewPatient']);  
  } 
   AddPatient()
  {
    this.router.navigate(['/AddPatient']);  
  }
  TodaysApp()
  {
    this.router.navigate(['/TodaysApp']);  
  }
  Consultation()
  {
    this.router.navigate(['/Consultation']);  
  }
  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 
  


}
