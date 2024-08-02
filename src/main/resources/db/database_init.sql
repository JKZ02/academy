CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE T_TEAM (
                        id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
                        name varchar(20) NOT NULL,
                        product varchar(20) NOT NULL,
                        created_at TIMESTAMP DEFAULT now(),
                        modified_at TIMESTAMP DEFAULT now(),
                        default_location varchar(10) NOT NULL,
                        CONSTRAINT location_limit CHECK (T_TEAM.default_location IN ('LISBON', 'PORTO', 'BRAGA'))
);

CREATE TABLE T_RACK (
                        id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
                        serial_number varchar(15) NOT NULL UNIQUE,
                        team_id uuid REFERENCES t_team (id),
                        status varchar(20) NOT NULL,
                        default_location varchar(10) NOT NULL,
                        created_at TIMESTAMP DEFAULT now(),
                        modified_at TIMESTAMP DEFAULT now(),
                        CONSTRAINT location_limit CHECK (T_RACK.default_location IN ('LISBON', 'PORTO', 'BRAGA')),
                        CONSTRAINT status_limit CHECK (T_RACK.status IN ('AVAILABLE', 'BOOKED', 'UNAVAILABLE'))
);


CREATE TABLE T_RACK_ASSET(
                             id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
                             asset_tag varchar(10),
                             rack_id uuid NOT NULL references T_RACK (id)
);


CREATE TABLE T_TEAM_MEMBER (
                               id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
                               team_id uuid REFERENCES t_team (id),
                               ctw_id varchar(8) NOT NULL,
                               name varchar(20) NOT NULL,
                               created_at TIMESTAMP DEFAULT now(),
                               modified_at TIMESTAMP DEFAULT now()
);

CREATE TABLE T_BOOKING (
                           rack_id uuid REFERENCES t_rack (id),
                           requester_id uuid REFERENCES T_TEAM_MEMBER (id),
                           book_from TIMESTAMP NOT NULL,
                           book_to TIMESTAMP NOT NULL,
                           created_at TIMESTAMP DEFAULT now(),
                           modified_at TIMESTAMP DEFAULT now()
);