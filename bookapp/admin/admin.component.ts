import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  constructor(private _bookService: BookService, private router:Router) { }

  ngOnInit() {
  }

   RegBook()
   {
    this.router.navigate(['/book']);   
   }

   RegMember()
   {
    this.router.navigate(['/member']);   
   }

   logout() {  
    console.log('logout');  
    this._bookService.logout();  
  } 
}
