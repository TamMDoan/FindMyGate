import { TestBed } from '@angular/core/testing';

import { GateServiceService } from './gate-service.service';

describe('GateServiceService', () => {
  let service: GateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
