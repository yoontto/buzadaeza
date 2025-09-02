package com.buzadaeza.gagyebu.txn;

import org.springframework.data.jpa.repository.JpaRepository;

//리포지토리
public interface TxnRepository extends JpaRepository<Txn, Long> {}