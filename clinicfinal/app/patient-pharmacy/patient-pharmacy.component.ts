import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-patient-pharmacy',
  templateUrl: './patient-pharmacy.component.html',
  styleUrls: ['./patient-pharmacy.component.scss']
})
export class PatientPharmacyComponent implements OnInit {

  constructor(private router:Router,private logout: LogoutService) { }

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

  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 
}
