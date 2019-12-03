import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ViewPatientHistoryService } from './view-patient-history.service';
import { Doctor } from '../doctor';
import { FrontOffice } from '../frontOffice';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-view-patient-history',
  templateUrl: './view-patient-history.component.html',
  styleUrls: ['./view-patient-history.component.scss']
})
export class ViewPatientHistoryComponent implements OnInit {

  history:Doctor[]
  labhistory:Doctor[]
  obshistory:Doctor[]
  patDet=new FrontOffice();
  ObserNote=new Doctor();
  constructor(private router:Router, private logout: LogoutService,private _patienthistory:ViewPatientHistoryService,private route:ActivatedRoute ) { }

  dId:number;
  regId:number;

  ngOnInit() {
    this.route.params.subscribe(params=>this.getIds(params['dId'],params['regId']))
    this.getpatientMedicineHistory();
    this. getpatientLabHistory();
    this. getpatientObsHistory();
    this.getPatient();
  }

  getIds(dId:number,regId:number){
    this.dId=dId;
    this.regId=regId;
  }
  addNotes(){
    if(this.ObserNote.obsNotes!=null){
    this.ObserNote.regId=this.regId;
    this.ObserNote.dId=this.dId;
      this._patienthistory.addObserv(this.ObserNote)
      .subscribe((response)=>{
        console.log(response)
        this.ObserNote.obsNotes=undefined;
      },(error)=>{
        console.log(error);
      });
    }
  }

  getPatient():void{
    this._patienthistory.getPatientDetails(this.regId)
    .subscribe((patData)=>{
      this.patDet=patData;
    },(error)=>{
      console.log(error);
    });
  }

  getpatientMedicineHistory():void{

    this. _patienthistory.getpatientMedicineHistory(this.regId).subscribe((histlist) =>
    {this.history= histlist,console.log(histlist);
    },(error) => {console.log(error)});
  }

  getpatientLabHistory():void{

    this. _patienthistory.getpatientLabHistory(this.regId).subscribe((histlist) =>
    {this.labhistory= histlist,console.log(histlist);
    },(error) => {console.log(error)});
  }

  getpatientObsHistory():void{

    this. _patienthistory.getpatientObsHistory(this.regId).subscribe((histlist) =>
    {this.obshistory= histlist,console.log(histlist);
    },(error) => {console.log(error)});
  }


  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
  }
  
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
  }
 
  MedRequest() 
  {
    this.router.navigate(['/MedRequest/'+this.dId+'/'+this.regId]);
  }
  labRequest()
   {
    this.router.navigate(['/labRequest/'+this.dId+'/'+this.regId]);
   }
  ViewDocApp()
  {
    this.router.navigate(['/ViewDocApp']);
  }
  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 



}
