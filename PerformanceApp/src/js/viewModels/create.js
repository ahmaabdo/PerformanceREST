/**
 * @license
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your incidents ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojknockout', 'promise', 'ojs/ojinputtext', 'ojs/ojbutton'],
  function (oj, ko, $) {

    function CreateViewModel() {
      var self = this;
      var urlRoot = "http://localhost:8080/webapi/employees/";

      //Input Texts
      self.first_name = ko.observable("Ahmad");
      self.last_name = ko.observable("Abdo");
      self.username = ko.observable("ahmad");
      self.salary = ko.observable(1000);

      //Create button -> POST method
      self.buttonSend = function () {
        $.ajax({
          type: "POST",
          url: urlRoot,
          dataType: "json",
          data: JSON.stringify({
            first_name: self.first_name(),
            last_name: self.last_name(),
            username: self.username(),
            salary: self.salary()
          }),
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          success: function () {
            alert("Account Successfully created");
          }
        });
      }


      // Below are a set of the ViewModel methods invoked by the oj-module component.
      // Please reference the oj-module jsDoc for additional information.

      /**
       * Optional ViewModel method invoked after the View is inserted into the
       * document DOM.  The application can put logic that requires the DOM being
       * attached here. 
       * This method might be called multiple times - after the View is created 
       * and inserted into the DOM and after the View is reconnected 
       * after being disconnected.
       */
      self.connected = function () {
        // Implement if needed
      };

      /**
       * Optional ViewModel method invoked after the View is disconnected from the DOM.
       */
      self.disconnected = function () {
        // Implement if needed
      };

      /**
       * Optional ViewModel method invoked after transition to the new View is complete.
       * That includes any possible animation between the old and the new View.
       */
      self.transitionCompleted = function () {
        // Implement if needed
      };
    }

    /*
     * Returns a constructor for the ViewModel so that the ViewModel is constructed
     * each time the view is displayed.  Return an instance of the ViewModel if
     * only one instance of the ViewModel is needed.
     */
    return new CreateViewModel();
  }
);
