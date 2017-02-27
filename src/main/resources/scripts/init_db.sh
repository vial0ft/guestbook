
# Creating dataBase guestbook
sudo -u postgres createdb guestbook

# Creating table user_comments
sudo -u postgres psql -d guestbook -f create_table.sql

#Insert few records in table
sudo -u postgres psql -d guestbook -f insert_fields.sql



