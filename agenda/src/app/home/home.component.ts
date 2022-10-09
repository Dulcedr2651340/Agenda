import { Component, OnInit } from '@angular/core';
import {Observable}from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError} from 'rxjs/operators';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

usuario:any ={};

contactos:any=[];

contacto:any ={};

crear:boolean =false;

loading:boolean=false;

  constructor(private http:HttpClient) { }

ngOnInit(): void {
    this.usuario=JSON.parse(localStorage.getItem("usuario"));
    if(!this.usuario){
      location.href="/";
    }
    else{
      this.contacto={usuarioCorreo:this.usuario.Correo,correoList:[],telefonoList:[],direccionList:[]};
      this.buscarContactos();
    }
  }
logout(){
    localStorage.removeItem("usuario");
    location.href="/"
  }
  buscarContactos(){
    this.loading=true;
    this.buscarContactosServicio().subscribe((Response:any)=>this.llenarContactos(Response));
  }
  buscarContactosServicio():Observable<any>{
    return this.http.get<any>("http://localhost:9091/contacto/buscar/correo/"+this.usuario.correo).pipe(
      catchError(e=>"error"))
  }
  llenarContactos(contactos:any){
    this.contactos = contactos;
    this.loading=false;
  }
  agregar(){
    this.crear =!this.crear;

  }
  crearContacto(){
    let formulario:any=document.getElementById("crear");
    let formularioValido:boolean = formulario.reportValidity();
    if(formularioValido){
      this.loading=true;
      this.contactoServicio().subscribe(
    data => this.finalizarCrearContacto(data)
      );
  }
}
contactoServicio(){
      var httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      }
      return this.http.post<any>("http://localhost:9091/contacto/guardar", this.contacto, httpOptions);
    }
    finalizarCrearContacto(contacto:any){
      if(contacto){
        alert("contacto creado exitosamente");
      }
      this.contacto={usuarioCorreo:this.usuario.correo,correoList:[],telefonoList:[],direccionList:[]};
      this.crear = true;
      this.buscarContactos();
    }
    agregarTelefono(){
      this.contacto.telefonoList.push({});
    }
    borrarTelefono(telefono:any){
      this.contacto.telefonoList.splice(this.contacto.telefonoList.indexOf(telefono),1);
    }
    agregarCorreo(){
      this.contacto.correoList.push({});
    }
    borrarCorreo(correo:any){
      this.contacto.correoList.splice(this.contacto.correoList.indexOf(correo),1);
    }
    agregarDireccion(){
      this.contacto.direccionList.push({});
    }
    borrarDireccion(direccion:any){
      this.contacto.direccionList.splice(this.contacto.correoList.indexOf(direccion),1);
    }

}
