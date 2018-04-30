/**
 * @license
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your incidents ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojknockout', 'promise', 'ojs/ojtable', 'ojs/ojinputtext', 'ojs/ojlabel', 'ojs/ojbutton'],
  function (oj, ko, $) {

    function AverageViewModel() {
      var self = this;
      var urlRoot = "http://localhost:8080/webapi/employees/";

      self.avrg = ko.observable();

      //Table
      self.data = ko.observableArray();


      self.getPerformances = function () {

        $.getJSON((urlRoot + self.username()), function (result) {
          $.each(result, function () {
            self.jobKnow(result.job_know),
              self.workQuality(result.work_quality),
              self.attitude(result.attitude),
              self.comSkills(result.com_skills),
              self.dependability(result.dependability),
              self.comments(result.comments)

          });
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
    return new AverageViewModel();
  }
);
