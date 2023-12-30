import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Gate } from '../../interfaces/gate-interface/gate';

@Injectable({
  providedIn: 'root'
})
export class GateServiceService {

  /*
  Import/inject httpclient, backend url, etc
  */

  // endpoint for gate controller
  private gateUrl = `http://localhost:8080/gate/`;

  constructor(private httpClient: HttpClient) { }

  getGate(gate: string): Observable<Gate>{
    console.log("fetching gate...");
    return this.httpClient.get<Gate>(this.gateUrl+`find?gate=${gate}`).pipe();
  }

  getPath(startGate: string, destGate: string): Observable<Gate[]>{
    console.log("finding path...");
    return this.httpClient.get<Gate[]>(this.gateUrl+`navigation?startGate=${startGate}&destGate=${destGate}`);
  }

}
