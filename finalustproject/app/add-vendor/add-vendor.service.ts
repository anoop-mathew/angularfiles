import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Vendor } from '../vendor';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddVendorService {

  constructor(private httpClient:HttpClient) { }

  addVendor(user:Vendor){
    let body=JSON.stringify(user);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}

    if(user.vendorId!=0){
      return this.httpClient.put(environment.APIUrl+'/saveVendor',body,options);
    }else{
    return this.httpClient.post(environment.APIUrl+'/saveVendor',body,options);
    }
  }

  getVendorById(vendorId:number):Observable<Vendor>{
    return this.httpClient.get<Vendor>(environment.APIUrl +'/viewVendor/'+ vendorId);
  }
}
