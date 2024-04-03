db.auth('root', '123')

db = db.getSiblingDB('customer')

db.createUser({
  user: 'customer',
  pwd: '123',
  roles:[ { role:"readWrite",
            db:"customer"
           }
        ],
  mechanisms:[ "SCRAM-SHA-1"] ,
});