package com.example.springboot_publish.fabuzhe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgRepository extends JpaRepository<Mqtmsg,Long> {
}
