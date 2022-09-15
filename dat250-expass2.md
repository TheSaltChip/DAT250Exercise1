## Expass 2

### Technical problems
Installing Derby was a bit confusing. Environment variables would not be 
set no matter what I did. But I randomly stumbled over a command that just did it.
Which was "set derby". Which solved it, I do not know how or why, but
it did the right thing.

Had a problem with the created database which were related to the
bidirectional relations of address and person, which were fixed by
having mapped by on the Person field in address. 
And then creating a JoinTable where I specified join colum and 
inverse join columns

### Link
[Link](expass2/)

### Database
Inspected the database by using IntelliJ's Database tool. Which 
listed all the tables and created a visualization of the schema.

List of created tables
- ADDRESS
- BANK
- CREDITCARD
- PERSON
- PERSON_ADDRESS
- PERSON_CREDITCARD
- PINCODE

### Pending issues
None
