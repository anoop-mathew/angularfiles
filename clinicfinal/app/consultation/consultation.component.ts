import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ConsultationService } from './consultation.service';
import { FrontOffice } from '../frontOffice';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-consultation',
  templateUrl: './consultation.component.html',
  styleUrls: ['./consultation.component.scss']
})
export class ConsultationComponent implements OnInit {

  availDoc:FrontOffice[];
  public consultation=new FrontOffice();
  public patDet=new FrontOffice();
  regFee:number;
  sName:string;
  constructor(private route:ActivatedRoute,private logout: LogoutService,private router:Router,private consultService:ConsultationService) { }

  ngOnInit() {
    this.route.params.subscribe(params=>this.getPatient(params['regId']));
    this.getAvailableDoc();
    this.sName=undefined;
    this.regFee=0;
  }

  getPatient(regId:number){
    this.consultService.getPatientDetails(regId)
    .subscribe((patData)=>{
      this.patDet=patData;
    },(error)=>{
      console.log(error);
    });
  }

  getAvailableDoc(){
    this.consultService.getAvaliableDoctors()
    .subscribe((availData)=>{
      this.availDoc=availData;
      console.log(this.availDoc);
    },(error)=>{
      console.log(error);
    });
  }

  getDoctor(){
    this.consultService.getDocAvail(this.sName)
    .subscribe((consultData)=>{
      this.consultation=consultData;
      console.log(this.consultation);
    },(error)=>{
      console.log(error);
    });
  }
  
 addAppoinment(){
  this.consultation.regId=this.patDet.regId;
  this.consultService.addDocAppoinment(this.consultation)
    .subscribe((response)=>{
      console.log(this.consultation);
     this.ViewPatient();
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
