import { Passenger } from "./passenger";

export class BookingDt {
    noOfPassenger: number;
    cost: number;
    userId: any;
    flightId: number;
    emailId: string;
    travelClass: string;
    passengerList: Passenger[];
}

