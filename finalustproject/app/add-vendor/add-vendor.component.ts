import { Component, OnInit } from '@angular/core';
import { AddVendorService } from './add-vendor.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Vendor } from '../vendor';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-add-vendor',
  templateUrl: './add-vendor.component.html',
  styleUrls: ['./add-vendor.component.scss']
})
export class AddVendorComponent implements OnInit {

  user = new Vendor();
  constructor(private router:Router,private route:ActivatedRoute,private addVendorService:AddVendorService,private logout: LogoutService) { }

  ngOnInit() {
    this.route.params.subscribe(params=>this.getVendorById(params['vendorId']));
  }


  saveVendor():void{

    this.addVendorService.addVendor(this.user)
    .subscribe((response)=>{
      console.log(response);
      this.reset();
      this.router.navigate(['/Home']);   
    },(error)=>{
      console.log(error);
    });
  }

  private reset(){
    this.user.vendorName = null;
    this.user.address = null;
    this.user.location=null;
    this.user.service = null;
    this.user.pincode = null;
    this.user.contactName = null;
    this.user.department = null;
    this.user.email = null;
    this.user.phone = null;
   
  }
  getVendorById(vendorId: number){
    this.addVendorService.getVendorById(vendorId)
    .subscribe((docData)=>{
      this.user=docData;
      console.log(this.user);
    },(error)=>{
      console.log(error);
    });
  }

  AddVendor(){
    this.router.navigate(['/AddVendor']);   
  }
  
  Logout(){
    console.log('Logout');  
    this.logout.Logout();
  }

  Home()
  {
    this.router.navigate(['/Home']);  
  }

  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
  }
  
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
  }


}
