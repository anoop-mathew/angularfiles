import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from './book';
import { Observable } from 'rxjs';
import { Login } from './login';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  formData: Login
  constructor(private _httpService: HttpClient,private router:Router) { }

  
  getAllBooks(): Observable<Book[]>{
    return this._httpService.get<Book[]>(environment.APIUrl +'/book');
  }

  addBook(book: Book){
    console.log(book.id);
    let body = JSON.stringify(book);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    if(book.id)
   {
      //return this._httpService.put(environment.APIUrl +'/updatebook', body, options);
      return this._httpService.put(environment.APIUrl +'/insertbook', body, options);
    }else{
      return this._httpService.post(environment.APIUrl +'/insertbook', body, options);
    }
    
    
  }


  deleteBook(bookId: string){
    return this._httpService.delete(environment.APIUrl +'/deletebook/'+ bookId);
  }

  getBookById(bookId: string): Observable<Book>{
    return this._httpService.get<Book>(environment.APIUrl +'/book/'+ bookId);
    
  }

  private handleError(error: Response){
    return Observable.throw(error);
  }

  getRole(formData:any):any{
    return this._httpService.get<Login>(environment.APIUrl +'/login/'+formData.username+'/'+formData.password);
 
}

logout() :void {    
  localStorage.setItem('isLoggedIn','false');    
  localStorage.removeItem('token');  
  localStorage.removeItem('tokenRoleId');
  this.router.navigate(['/login']);   
  } 
}

