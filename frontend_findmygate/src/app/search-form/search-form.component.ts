import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { GateServiceService } from '../services/gate-service/gate-service.service';
import { Gate } from '../interfaces/gate-interface/gate';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrl: './search-form.component.css'
})
export class SearchFormComponent {
  startGateMessage: String = "";
  destGateMessage: String = "";
  path: Gate[] = [];

  constructor(private gateService: GateServiceService){}

  // create a form for the user to submit
  // will take two gates, start and destination
  // TODO: later, get the user's location and guesstimate what gate they're at
  /*
  Things to keep in mind: put form validators so that
  empty isn't a valid input. See if you can make(?) a validator that follows a regex for gates
  If that's difficult... probably is, there are different number of gates in each terminal...
  take invalid inputs and do the checking in the backend. i.e. return some response code
  that indicates it was an invalid input. See if you can somehow indicate which one was invalid
  */

  gateForm = new FormGroup({
    startGate: new FormControl(null!, Validators.required),
    destGate: new FormControl('', Validators.required)
  })

  onSubmit(){
    // have to add the ?/! because .get might return null
    var start = this.gateForm.get('startGate')!.value;
    var dest = this.gateForm.get('destGate')!.value;

    this.startGateMessage = `Start gate value: ${start}`;
    this.destGateMessage = `Destination gate value: ${dest}`;

    this.displayPath(start!, dest!);
  }

  displayPath(startGate: string, destGate: string){
    this.gateService.getPath(startGate, destGate).subscribe(
      gates => this.path = gates
    );
  }

  /*
  Form works.
  Think about your data model. You'll need to create an interface, then a service, and the 
  data model is important to do that.
  right now thinking of Gates as an entity...
  another possibility is just a list of strings for now...
  i.e. { gates: [ str, str, str, str] }
  */

}
