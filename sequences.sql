create table MY_SEQUENCES (
  sequence_name varchar(255) not null,
  next_val bigint,
  primary key (sequence_name)
)