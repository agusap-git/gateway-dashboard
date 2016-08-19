/**
 * Created by Administrator on 8/17/2016.
 */
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class BusinessPartnerService {

  constructor(private _http: Http) {}

  getBusinessPartners() {
    // return this._http.get('/resources/data/business-partners.json')
    //   .map(res => res.json());

    return this._http.get('http://localhost:4201/rest/business-partners')
      .map(res => res.json());
  }
}
