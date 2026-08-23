# Parking Lot System 

## ParkingLot

- name : string
- List&lt;Level&gt; levels

+ getLevel(int) : Level

## Level

- floorNumber : int
- List&lt;ParkingSpot&gt; spots

+ getAvailableSports() : List&lt;ParkingSpot&gt;

`getAvailableSports()` - returns the fee sports of a particular floor/level

## ParkingRate

+ calculateFee(VehicleType) : double

`calculateFee(VehicleType)` - returns the fee based on the vehicle type

## ParkingSpot

- spotId : string
- spotType : spotType
- isFree : bool
- Vehicle : vehicle

+ assignVehicle(Vehicle)
+ removeVehicle()

`spotType` is an enum

## Ticket

- ticketId : string
- entryTime : datetime
- exitTime : datetime
- ticketStatus : TicketStatus
- vehicleType : VehicleType

+ calculateFree()

`TicketStatus`, `VehicleType` are enum

## EntryGate

- parkingSpotManager : ParkingSpotManager

+ issueTicket(Vehicle) : Ticket

## ExitGate

+ processPayment(Ticket) : Payment

## Abstract Gate

- gateId : string
<br>
inherited by EntryGate and ExitGate

## Payment

- amount : double
- paymentMode : PaymentMode

+ processPayment()

## Abstract Vehicle

- licensePlate : string
- VehicleType : vehicleType
  <br>
  Car,Bike, Truck are  the examples of vehicles.
  <br>
VehicleType is an enum type
## ParkingSpotManager

- parkingLot : ParkingLot

+ findAvaiableSport(VehicleType) : ParkingSpot
+ releaseSpot(ParkingSpot)
<br>
findAvaiableSport() - find across all the levels.

