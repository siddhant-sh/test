import { TestBed } from '@angular/core/testing';

import { EnrolledlistService } from './enrolledlist.service';

describe('EnrolledlistService', () => {
  let service: EnrolledlistService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EnrolledlistService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
