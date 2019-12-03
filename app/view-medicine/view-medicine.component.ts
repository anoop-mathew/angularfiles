import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { ViewMedicineService } from './view-medicine.service';
import { AddMedicineService } from '../add-medicine/add-medicine.service';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-view-medicine',
  templateUrl: './view-medicine.component.html',
  styleUrls: ['./view-medicine.component.scss']
})
export class ViewMedicineComponent implements OnInit {

  constructor(private router:Router, private logout: LogoutService,private _viewMedicine:ViewMedicineService,private _addMedicine:AddMedicineService) { }
  medicines:Admin[];

  ngOnInit() {
    this.getAllMedicines();
  }

  
  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
  }
  
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
  }

  getAllMedicines(): void{
    this._viewMedicine.getAllMedicines()
    .subscribe((medicineData) =>{
      this.medicines=medicineData;    
      console.log(medicineData);
    }, (error) =>{
      console.log(error);
    });
  }
   
  disableMedicine(med:Admin){
      this._viewMedicine.disableMed(med)
      .subscribe((response) =>{
        this.getAllMedicines();
      }, (error) =>{
        console.log(error);
      });
  }

  editMedicine(medId: string):void{

      console.log(medId);
      this.router.navigate(['/updateMedicine/'+medId]);

  }

  //medicine Search in Admin
  searchMedicine(search: string): void{
    if (search!=null){
   this._viewMedicine.SearchMedicine(search)
   .subscribe((medicineData)=>{
     //this.search=undefined;
     this.medicines=medicineData,
     console.log(this.medicines);
   }, (error) =>{
     console.log(error);
   });
 }else{
   this.getAllMedicines();
 }
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

  AddMedicine()
  {
    this.router.navigate(['/AddMedicine']);   
  }
  Logout() {  
    console.log('Logout');  
    this.logout.Logout();
  } 

}
